class Client (override val processor: processor, override val graphics: Graphics, override val ram: RAM):  {
    fun info():String{
        println("Komputer używa procesora $processor, karty graficznej $graphics i posiada $ram pamięci RAM")
    }
}