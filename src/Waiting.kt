import java.lang.Thread.sleep

class Waiting {
    open fun w(a:Long){
        sleep(a)
    }
    open fun wF(a:Long,b:Int){
        for(i in 0..b){
            w(a)
            print(".")
        }
        w(a)
        println()
    }
    open fun r(a:Int):Int{
        var random = (Math.random()*a).toInt()
        if(random == 0){
            random += 1
        }
        return random
    }
}