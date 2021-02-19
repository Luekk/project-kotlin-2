import kotlin.math.sqrt

class Server(override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    private val w = Waiting()
    fun req(a:Int,b:Int,d:Float,e:Float,c:String,IF:String){
        serverReceive()
        w.wF(1000,1)
        if(IF == "i") {
            if (c == "p" || c == "m" || c == "r" || c == "d" || c == "e" || c == "s") {
                resInt(a, b, d, e, c)
            }
        }
        else if(IF == "f") {
            if (c == "p" || c == "m" || c == "r" || c == "d" || c == "e" || c == "s") {
                resFloat(a, b, d, e, c)
            }
        }
        else if (c=="ip" && IF == "n"){
            ipCheck()
        }
        else if(c=="restart" && IF == "n"){
            restart()
        }
        else if(c=="list" && IF == "n"){
            list()
        }
        else if(c=="status" && IF == "n"){
            statusServer()
        }
        else{
            log()
        }
    }
    fun serverReceive(){
        println("Serwer: Odebrano zapytanie")
    }
    private fun resInt(a:Int,b:Int,d:Float,e:Float,c:String){
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
            val d = a.toFloat()
            val e = b.toFloat()
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
    private fun resFloat(a:Int,b:Int,d:Float,e:Float,c:String){
        fun plus(){
            println("Serwer: Wynik dodawania $d + $e = ${d+e}")
        }
        fun minus(){
            println("Serwer: Wynik odejmowania $d - $e = ${d-e}")
        }
        fun sqrt(){
            println("Serwer: Wynik kwadratu liczb $d i $e to po kolei ${d*d} i ${e*e}")
        }
        fun multiply(){
            println("Serwer: Wynik mnożenia liczb $d i $e to ${d*e}")
        }
        fun divide(){
            println("Serwer: Wynik dzielenia liczb $d i $e to ${d/e}")
        }
        fun element(){
            println("Serwer: Pierwiastek liczb $d i $e to ${sqrt(d)} i ${sqrt(e)}")
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
    private fun ipCheck(){
        println(sip)
    }
    private fun restart(){
        println("Restartowanie serwera")
        for (i in 0..1){
            w.wF(1000, 2)
        }
        println("Serwer uruchomiony ponownie. Ip: $sip Port: $sport")
    }
    private fun list(){
        val client = "Client 1 port: $port ip: $ip"
        val client1 = "Client 2 port: ? ip: ? -- disconnected"
        val client2 = "Client 3 port ? ip: ? -- disconnected"
        val list = mutableListOf<String>(client, client1, client2)
        println("Lista połączeń: ")
        for(client in 0..list.size-1){
            println(list[client])
        }

    }
    private fun log(){
        println("Serwer komunikował się z: ")
        println("Klientem o ip $ip działającym na porcie: $port")
        println("oraz z dwoma innymi klientami")
    }
}