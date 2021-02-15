import java.util.Scanner

class Client (override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))
    val w = Waiting()
    val scan = Scanner(System.`in`)


    fun serverSend() {
        fun sending() {
            println("Wpisz pierwszą liczbę")
            print("$ ")
            val num1 = scan.nextInt()
            println("Wpisz drugą liczbę")
            print("$ ")
            var num2 = scan.nextInt()
            println("Wybierz sposób liczenia")
            print("$")
            var type = readLine()

            if(type == "plus" || type == "+"){
                server.req(num1,num2,"p")
            } else if (type == "minus" || type == "-"){
                server.req(num1,num2,"m")
            }
        }
        println("Wyślij zapytanie 'Math' do serwera")
        val type = readLine()
        if(type == "Math") {
            sending()
        } else {
            println("Bad syntax")
        }
    }

    fun serverPing() {
        println("Klient: pingowanie serwera")
        for (i in 0..3) {
            var rand = random(5)
            w.w(1000)
            server.serverReceive()
            println("Klient: ping: 142.532.65.34 port: 81 time: $rand ms")
        }
        println()
        println("Finished with 4 of 4 send and 0 lost.")
        return
    }

    fun clientTime() {
        var random = (Math.random() * 10).toInt()
        if (random == 0) {
            random = 1
        }
        println("Klient: Czas dostępu do serwera wynosi ${random}ms")
    }
    fun clientIp(){
        println("$ip")
    }
    private fun random(a:Int):Int{
        var random = (Math.random()*a).toInt()
        if(random == 0){
            random += 1
        }
        return random
    }

}