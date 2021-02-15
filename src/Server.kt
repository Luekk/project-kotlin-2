class Server(override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    val w = Waiting()

    fun req(a:Int,b:Int):Int{
        println("Serwer: Odebrano zapytanie")
        res(a,b,"k")
        return a+b
    }
    fun serverReceive(){
        println("Serwer: Odebrano zapytanie")
    }
    private fun res(a:Int,b:Int,c:String){
        fun waitTime(a:Long) {Thread.sleep(a)}
        fun waiting():String {
            for (i in 0..2) {
                waitTime(1000)
                print(".")
            }
            waitTime(1000)
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
    fun restart(){
        println("Restartowanie serwera")
        for (i in 0..1){
            w.wF(1000, 2)
        }
        println("Serwer działa")
    }
}