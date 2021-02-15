import kotlin.math.sqrt

class Server(override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    val w = Waiting()

    fun req(a:Int,b:Int,c:String){
        serverReceive()
        w.wF(1000,1)
        if(c=="p"||c=="m"||c=="r"||c=="d"||c=="e"||c=="s"){res(a,b,c)}
    }
    open fun serverReceive(){
        println("Serwer: Odebrano zapytanie")
    }
    private fun res(a:Int,b:Int,c:String){
        fun plus(){
            println("Serwer: Wynik dodawania $a + $b = ${a+b}")
        }
        fun minus(){
            println("Serwer: Wynik odejmowania $a - $b = ${a-b}")
        }
        fun sqrt(){
            println("Serwer: Wynik kwadratu liczb $a i $b to po kolei ${a*a} i ${a*b}")
        }
        fun multiply(){
            println("Serwer: Wynik mnożenia liczb $a i $b to ${a*b}")
        }
        fun divide(){
            println("Serwer: Wynik dzielenia liczb $a i $b to ${a/b}")
        }
        fun element(){
            var d = a.toFloat()
            var e = b.toFloat()
            println("Serwer: Pierwiastek liczb $a i $b to ${sqrt(d)} i ${sqrt(e)}")
        }
        if(c == "p"){plus()}
        else if (c == "m"){minus()}
        else if(c == "r"){multiply()}
        else if(c == "d"){divide()}
        else if(c == "s"){sqrt()}
        else if(c == "e"){element()}
        else {println("Bad syntax")}
        return
    }
    fun restart(){
        println("Restartowanie serwera")
        for (i in 0..1){
            w.wF(1000, 2)
        }
        println("Serwer działa")
    }
}