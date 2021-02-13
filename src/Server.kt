import java.lang.Thread.sleep

class Server(override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    fun req(a:Int,b:Int):Int{
        println("Serwer: Odebrano zapytanie")
        println(a)
        res(a,b)
        return a+b
    }
    private fun res(a:Int,b:Int){
        fun waiting():String {
            for (dot in 0..2) {
                Thread.sleep(1000)
                print(".")
            }
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