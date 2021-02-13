abstract class Computer{
    abstract val processor: Processor
    abstract val graphics: Graphics
    abstract val ram: RAM

    open fun infoClient(){
        println("Komputer używa procesora ${processor.info()}, karty graficznej ${graphics.info()} i posiada ${ram.info()}GB pamięci RAM")
    }
    open fun infoServer(){
        println("Serwer używa procesora ${processor.info()}, posiada ${ram.info()} i ${graphics.info()}")
    }
}