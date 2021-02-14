import java.lang.Thread.sleep

class Server(override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    fun req(a:Int,b:Int):Int{
        println("Serwer: Odebrano zapytanie")
        res(a,b)
        return a+b
    }
    fun serverReceive(){
        println("Serwer: Odebrano zapytanie")
    }
    private fun res(a:Int,b:Int){
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
    private fun dotting(){
        fun waitTime(a:Long) {Thread.sleep(a)}
        for (i in 0..2){
            waitTime(1000)
            print(".")
        }
        waitTime(1000)
        println()
    }
    fun restart(){
        println("Restartowanie serwera")
        for (i in 0..1){
            dotting()
        }
        println("Serwer działa")
    }
}