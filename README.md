# ConsoleChat

Приложение для обмена сообщениями через консоль
Учебный проект для того, чтобы понять как в примитивном случае устроены:

* многопоточность
* потоки ввода вывода
* средства для чтения данных из потока и записи данных в него.
* сокет

Предсталвяет из себя консольное приложение, запускаемое на двух компьютерах, находящихся в одной локальной сети.

Как работает:
После запуска:
    Компьютер 1 ожидает подключение компьютера 2.
    Компьютер 2 подключается к серверу.
    После этого можно будет начать обмениваться сообщениями через консоль
