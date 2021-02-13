class Client(val processor: String, val graphics: String, val ram: String){
    fun info(){
        println("Procesor: $processor")
        println("Karta graficzna: $graphics")
        println("Pamięć RAM: $ram")
    }
}