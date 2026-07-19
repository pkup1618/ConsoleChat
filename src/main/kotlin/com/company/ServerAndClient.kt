package com.company

import java.io.InputStream
import java.io.OutputStream
import kotlin.concurrent.thread


class DialogBySocket(
    val inputStream: InputStream,
    val outputStream: OutputStream
) {
    val readingProcess = initReadingProcess()
    val writingProcess = initWritingProcess()

    fun close() {
        runCatching { inputStream.close() }
        runCatching { outputStream.close() }
    }

    fun initReadingProcess(): Thread {
        return thread {
            try {
                val reader = inputStream
                    .reader(charset = Charsets.UTF_8)
                    .buffered()

                while (true) {
                    val message: String? = reader.readLine()
                    when (message) {
                        null -> {
                            println("Socket was closed"); break
                        }

                        else -> {
                            println(message)
                        }
                    }
                }
            } catch (e: Exception) {
                println("Reading error or stream closed: ${e.message}")
            }

            close()
        }
    }

    fun initWritingProcess(): Thread {
        return thread {
            try {
                val writer = outputStream
                    .writer(charset = Charsets.UTF_8)
                    .buffered()

                while (true) {
                    val message: String? = readlnOrNull()
                    when (message) {
                        null -> {
                            println("Process was closed"); break
                        }

                        else -> {
                            writer.write(message + "\n") // Важно \n
                            writer.flush()
                        }
                    }
                }
            } catch (e: Exception) {
                println("Reading error or stream closed: ${e.message}")
            }

            close()
        }
    }
}
