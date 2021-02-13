class Server(override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    fun req(a:Int,b:Int):Int{
        println("Serwer: Odebrano zapytanie")
        res(a,b)
        return a+b
    }
    private fun res(a:Int,b:Int){
        val waitTime = Thread.sleep(1000)
        fun waiting():String {
            for (i in 0..2) {
                waitTime
                print(".")
            }
            waitTime
            println()
            return "end"
        }
        fun multiply(a:Int,b:Int):Int {
            return a * b
        }
        println("Przetwarzanie zapytania")
        val wait = waiting()
        if(wait == "end"){
            println(multiply(a,b))
        }
    }
}