import java.lang.Thread.sleep

class Server(override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    fun req(a:Int,b:Int):Int{
        println("Serwer odebrał zapytanie")
        println(a)
        res(a,b)
        return a+b
    }
    fun res(a:Int,b:Int){
        println("Przetwarzanie zapytania")
        fun waiting():String {
            for (dot in 0..2) {
                Thread.sleep(1000)
                var dot = "."
                print(dot)
            }
            return "end"
        }
        val wait = waiting()
        if(wait == "end"){
            val multiply = a*b
            println()
            println(multiply)
        }
    }
}