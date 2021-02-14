import java.lang.Thread.sleep

class Client (override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))

    private fun waitTime(a: Long) {
        Thread.sleep(a)
    }

    fun serverSend() {
        println("Client: Wysyłanie zapytania do serwera.")
        Thread.sleep(2000)
        println("Client: Wysłano zapytanie.")
    }

    fun serverPing() {
        println("Klient: pingowanie serwera")
        for (i in 0..3) {
            var random = (Math.random() * 5).toInt()
            if (random == 0) {
                random = 1
            }
            waitTime(1000)
            server.serverReceive()
            println("Klient: ping: 142.532.65.34 port: 81 time: ${random}ms")
        }
        println()
        println("Finished with 4 of 4 send and 0 lost.")
        return
    }

    fun clientTime() {
        var random = (Math.random() * 10).toInt()
        if (random == 0) {
            random = 1
        }
        println("Klient: Czas dostępu do serwera wynosi ${random}ms")
    }
    fun clientIp(){
        println("$ip")
    }

}