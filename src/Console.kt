import kotlin.system.exitProcess

class Console() {
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
        else if(type == "server -h" || type == "server -help"){
            serverHelp()
        }
        else if(type == "start"){
            println("Prosze uruchomic pierwsze klienta za pomocą komendy 'client start' a potem serwer za pomocą 'server start'")
            commandLine()
        }
        else if(type == "client -params") {
            client.infoClient()
        }
        else if(type == "server -params"){
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
        return
    }
    private fun serverHelp(){
        println("-r - restart serwera")
        println("-s - aktualny status serwera")
        println("-ip - pokazuje adres IP serwera")
        println("-l - logi serwera")
        return
    }
    private fun commandLine():Boolean{
        var booleanClient = false
        var booleanServer = false
        var type = readLine()
        println("KOMEDYYYY")
        if(type == "client start" || type == "server start"){
            when(type){
                "client start" ->{
                    println("client started")
                    safety("c")
                }
                "server start" -> {
                    println("server started")
                    booleanServer = true
                    safety("s")
                }
                else -> println("Spróbuj ponownie")
            }
        }
        val safety = safety()
        if(safety() == true)
        else if(type == "client -p"){client.serverPing()}
        else if(type == "client -p"){ client.serverPing()}
        else if(type == "client -t"){client.clientTime()}
        else if(type == "client -ip"){client.clientIp()}
        println("$booleanClient, $booleanServer")
    }


    private fun randInt(a:Int){
        var random = (Math.random()*a).toInt()
        if(random == 0){
            random = 1
        }
    }
    open fun safety(letter:String){
        var booleanClient = false
        var booleanServer = false
        if(letter == "c"){booleanClient = true}
        if(letter == "s"){booleanServer = true}
        else{
            booleanClient = false
            booleanClient = false
        }
        return
    }
}