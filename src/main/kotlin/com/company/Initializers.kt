package com.company

import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import javax.net.SocketFactory


val serverPort: Int = System.getenv("sp")?.toInt() ?: throw Exception("server port not defined")
//    val clientPort: Int = System.getenv("cp")?.toInt() ?: throw Exception("client port not defined")

val side = when (System.getenv("side")) {
    "server" -> "server"
    "client" -> "client"
    else -> throw Exception("not valid com.company.side env param")
}


fun initAsServer(): DialogBySocket {
    val serverSocket = ServerSocket(serverPort)
    println("server waits for connection")
    println("Server Address: ${serverSocket.inetAddress}")

    val socket = serverSocket.accept()
    println("client has connected")

    val dialogBySocket = DialogBySocket(
        inputStream = socket.inputStream,
        outputStream = socket.outputStream
    )

    return dialogBySocket
}


fun initAsClient(): DialogBySocket {
    val socketAddress = InetSocketAddress(InetAddress.getLocalHost(), serverPort)
    val clientSocket = SocketFactory
        .getDefault()
        .createSocket()

    println("client tries to connect")
    clientSocket.connect(socketAddress)
    println("Connected")
    println("Client Address: ${clientSocket.inetAddress}")

    val dialogBySocket = DialogBySocket(
        clientSocket.inputStream,
        clientSocket.outputStream
    )

    return dialogBySocket
}


fun main() {
    when (side) {
        "server" -> initAsServer()
        else -> initAsClient()
    }
}