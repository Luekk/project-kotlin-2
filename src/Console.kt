import kotlin.system.exitProcess

class Console {
    val client = Client(Processor("Intel Core I7"), Graphics("RTX 3090"), RAM(16))
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))

    fun init(){
        println("Emulacja server-client...")
        println("Wpisz -h lub -help aby zobaczyć pomoc")
        println("Jeżeli chcesz odrazu zacząć emoluwać klienta i serwera wpisz start.")
        start()
    }
    private fun start():String{
        println("BRSBSGFDDF")
        var type = readLine().toString()
        if(type == "-h" || type == "-help" || type == "h" || type == "help"){
            help()
        }
        else if(type == "exit"){
            exitProcess(0)
        }
        else if(type == "client -h" || type == "client -help"){
            clientHelp()
        }
        else if(type == "start"){
            println("Prosze uruchomic pierwsze klienta za pomocą komendy 'client start' a potem serwer za pomocą 'server start'")
            commandLine()
        }
        else if(start() == "client -params") {
            client.infoClient()
        }
        else if(start() == "server -params"){
            server.infoServer()
        }
        else{
            println("Bad syntax")
            start()
        }
        return type
    }
    private fun help(){
        println("Aby zobaczyć właściwości klienta wystarczy wpisac client -{komenda}")
        println("Aby zobaczyć właściwości serwera proszę wpisać server -{komenda}")
        println("Aby zobaczyć dostępne komendy klienta lub serwera proszę wpisać client/server -h")
        return
    }
    private fun clientHelp(){
        println("-p  -  pinguje serwer")
        println("-t  -  pokazuje czas dostępu do serwera")
        println("-ip  -  pokazuje adres IP Klienta")
        println("-status  -  pokazuje aktualny status klienta")
        println("-params  -  pokazuje parametry komputera")
    }
    private fun commandLine(){
        println("KOMEDYYYY")
    }
}