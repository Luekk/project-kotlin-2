import java.lang.Thread.sleep

class Waiting {
    fun w(a:Long){
        sleep(a)
    }
    fun wF(a:Long,b:Int){
        for(i in 0..b){
            w(a)
            print(".")
        }
        w(a)
        println()
    }
}