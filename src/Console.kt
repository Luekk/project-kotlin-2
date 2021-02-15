import kotlin.system.exitProcess

class Console() {
    val client = Client(Processor("Intel Core I7"), Graphics("RTX 3090"), RAM(16))
    val server = Server(Processor("AMD Epyc 7742"), Graphics("none"), RAM(4096))

    fun init(){
        println("Emulacja server-client...")
        println("Jeżeli chcesz odrazu zacząć emoluwać klienta i serwera wpisz start.")
        start()
    }
    private fun start():String{
        var type = readLine().toString()
        if(type == "-h" || type == "-help" || type == "h" || type == "help"){
            help()
        }
        else if(type == "exit"){
            exitProcess(0)
        }
        else if(type == "start"){
            println("Prosze uruchomic klienta za pomocą komendy 'client start'")
            safetyCheck()
        }
        else if(type == "client -params") {
            client.infoClient()
        }
        else if(type == "server -params"){
            server.infoServer()
        }
        else{
            println("Bad syntax. Wpisz start aby przejśc dalej")
            start()
        }
        return type
    }
    private fun help(){
        println("Aby zobaczyć właściwości klienta wystarczy wpisac client -{komenda}")
        println("Aby zobaczyć właściwości serwera proszę wpisać server -{komenda}")
        println("Aby zobaczyć dostępne komendy klienta lub serwera proszę wpisać client/server -h")
        safeDone()
    }
    private fun clientHelp(){
        println("-p  -  pinguje serwer")
        println("-t  -  pokazuje czas dostępu do serwera")
        println("-s  -  pokazuje aktualny status klienta")
        println("-ip  -  pokazuje adres IP Klienta")
        println("-params  -  pokazuje parametry komputera")
        println("send  -  wysyła zapytanie do serwera")
        safeDone()
    }
    private fun serverHelp(){
        println("-r - restart serwera")
        println("-s - aktualny status serwera")
        println("-ip - pokazuje adres IP serwera")
        println("-l - logi serwera")
        safeDone()
    }
    private fun safetyCheck(){
        var type = readLine()
        safetyClient("t")
        safetyServer("t")

        if(type == "client start") {
            println("Klient uruchomiony")
            println("Aby zobaczyć dostępne komendy wpisz client/server -h/help")
            safeDone()
        } else {
            println("Bad syntax.")
            safetyCheck()
        }
    }


    private fun safeDone(){
        var type = readLine()
        if(type == "client -s"){client.statusClient()}
        else if(type == "client -h" || type == "client -help"){clientHelp()}
        else if(type == "server -h" || type == "server -help"){serverHelp()}
        else if(type == "client -p"){client.serverPing()}
        else if(type == "client -t"){client.clientTime()}
        else if(type == "client -ip"){client.clientIp()}
        else if(type == "client -params"){client.infoClient()}
        else if(type == "server -params"){server.infoServer()}
        else if(type == "server -s"){server.req(1,1,"status")}
        else if(type == "server -r"){server.req(1,2,"restart")}
        else if(type == "server -ip"){server.req(1,1,"ip")}
        else if(type == "exit"){exitProcess(0)}
        else if(type == "client send"){client.serverSend()}
        else{"Bad syntax"}
        safeDone()
    }
    open fun safetyClient(let:String):Boolean{
        return let == "t"
    }
    open fun safetyServer(let:String):Boolean{
        return let == "t"
    }
}