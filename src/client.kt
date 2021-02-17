import java.util.Scanner

class Client (override val processor: Processor, override val graphics: Graphics, override val ram: RAM): Computer() {
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))
    val w = Waiting()
    val scan = Scanner(System.`in`)


    fun serverSend() {
        fun sending() {
            fun intSend() {
                var float = 0.toFloat()
                println("Wpisz pierwszą liczbę")
                print("$ ")
                var num1 = scan.nextInt()
                println("Wpisz drugą liczbę")
                print("$ ")
                var num2 = scan.nextInt()
                println("Wybierz sposób liczenia")
                print("$ ")
                var type = readLine()

                if (type == "plus" || type == "+" || type == "dodawanie") {
                    server.req(num1, num2,float,float, "p","i")
                } else if (type == "minus" || type == "-" || type == "odejmowanie") {
                    server.req(num1, num2,float,float, "m","i")
                } else if (type == "*" || type == "mnozenie" || type == "mnożenie") {
                    server.req(num1, num2,float,float, "r","i")
                } else if (type == "/" || type == "dzielenie" || type == "dziel") {
                    server.req(num1, num2,float,float, "d","i")
                } else if (type == "**" || type == "kwadrat" || type == "razy2") {
                    server.req(num1, num2,float,float, "s","i")
                } else if (type == "pierwiastek" || type == "element" || type == "pierw") {
                    server.req(num1, num2,float,float, "e","i")
                } else {
                    println("Bad syntax")
                }
            }
            fun floatSend():Float {
                println("Wpisz pierwszą liczbę")
                print("$ ")
                var num1 = readLine()!!.toFloat()
                println("Wpisz drugą liczbę")
                print("$ ")
                var num2 = readLine()!!.toFloat()
                println("Wybierz sposób liczenia")
                print("$ ")
                var type = readLine()

                if (type == "plus" || type == "+" || type == "dodawanie") {
                    server.req(0, 0,num1,num2, "p","f")
                } else if (type == "minus" || type == "-" || type == "odejmowanie") {
                    server.req(0, 0,num1,num2, "m","f")
                } else if (type == "*" || type == "mnozenie" || type == "mnożenie") {
                    server.req(0, 0,num1,num2, "r","f")
                } else if (type == "/" || type == "dzielenie" || type == "dziel") {
                    server.req(0, 0,num1,num2, "d","f")
                } else if (type == "**" || type == "kwadrat" || type == "razy2") {
                    server.req(0, 0,num1,num2, "s","f")
                } else if (type == "pierwiastek" || type == "element" || type == "pierw") {
                    server.req(0, 0,num1,num2, "e","f")
                } else {
                    println("Bad syntax")
                }
                var sum = num1 + num2
                return sum
            }
            println("Rodzaj liczby: Int/Float")
            var numtype = readLine()
            if(numtype == "Int"){
                intSend()
            }
            else if(numtype == "Float"){
                floatSend()
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
            w.w(1000)
            server.serverReceive()
            println("Klient: ping: 142.532.65.34 port: 81 time: ${w.r(5)} ms")
        }
        println()
        println("Finished with 4 of 4 send and 0 lost.")
    }

    fun clientTime() {
        println("Klient: Czas dostępu do serwera wynosi ${w.r(10)}ms")
    }
    fun clientIp(){
        println("$ip")
    }
    override fun info(){
        super.infoClient()
    }

}