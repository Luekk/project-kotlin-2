abstract class Computer{
    abstract val processor: Processor
    abstract val graphics: Graphics
    abstract val ram: RAM
    val port = 80
    val ip = "192.168.567.12"
    val sport = 81
    val sip = "142.532.65.34"

    open fun infoClient(){
        println("Komputer używa procesora ${processor.info()}, karty graficznej ${graphics.info()} i posiada ${ram.info()}GB pamięci RAM")
    }
    open fun infoServer(){
        println("Serwer używa procesora ${processor.info()}, posiada ${ram.info()} i ${graphics.info()}")
    }
    open fun statusClient(){
        println("Klient działa i posiada ip: $ip na porcie $port")
    }
    open fun statusServer(){
        println("Serwer działa i posiada ip: $sip na porcie $sport")
    }

}