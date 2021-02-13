import java.lang.Thread.sleep

class Client (override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    fun serverSend(){
        println("Client: Wysyłanie zapytania do serwera.")
        Thread.sleep(2000)
        println("Client: Wysłano zapytanie.")
    }
}