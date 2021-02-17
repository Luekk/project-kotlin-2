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
    fun r(a:Int):Int{
        var random = (Math.random()*a).toInt()
        if(random == 0){
            random += 1
        }
        return random
    }
}