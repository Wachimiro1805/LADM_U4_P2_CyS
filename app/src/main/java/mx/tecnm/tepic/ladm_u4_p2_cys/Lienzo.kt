package mx.tecnm.tepic.ladm_u4_p2_cys

import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Lienzo(p:MainActivity) : View(p){

    var cont=0
    var state=true

    var hDia = true
    var puntero = p
    var posX = 150f
    var posY = 1400f

    override fun onDraw(c: Canvas) {

        var Thread = Hilo1(this)
        if (state){
            Thread.start()
            state=false
        }
        invalidate()

        super.onDraw(c)
        val p = Paint()

        if(hDia){
            c.drawColor(Color.BLUE)

            //Montaña Derecha
            p.color= Color.argb(255,0,187,45)
            c.drawCircle(1065f,1650f,800f,p)

            //Montaña Izquierda
            p.color= Color.argb(255,0,143,57)
            c.drawCircle(0f,1650f,700f,p)

            //Sol
            p.color= Color.YELLOW
            c.drawCircle(250f+cont,250f,100f,p)

            //Sonrisa
            p.color= Color.BLACK
            c.drawArc(300f,200f,200f,100f,0f,180f,true,p)

            //Arbol Derecha
            p.color= Color.argb(255,75,54,33)
            c.drawRect(900f,900f,850f,800f,p)
            //Hojas
            p.color= Color.argb(255,100,150,50)
            c.drawOval(900f,800f,800f,700f,p)
            c.drawOval(900f,825f,800f,725f,p)
            c.drawOval(950f,825f,850f,725f,p)
            c.drawOval(950f,785f,850f,685f,p)

            //Arbol Izquierda
            p.color= Color.argb(255,75,54,33)
            c.drawRect(100f,1000f,150f,1100f,p)
            //Hojas
            p.color= Color.argb(255,100,250,50)
            c.drawOval(50f,900f,150f,1000f,p)
            c.drawOval(50f,925f,150f,1025f,p)
            c.drawOval(100f,925f,200f,1025f,p)
            c.drawOval(100f,885f,200f,985f,p)

            //Casa
            p.color= Color.argb(255,204,119,34)
            c.drawRect(800f,1700f,600f,1550f,p)
            //Techo
            p.color= Color.argb(255,200,200,80)
            c.drawRect(850f,1500f,550f,1600f,p)
            //Puerta
            p.color= Color.argb(255,218,138,95)
            c.drawRect(700f,1700f,620f,1650f,p)
            //Ventana
            p.color= Color.argb(255,62,95,138)
            c.drawCircle(750f,1650f,25f,p)
        }else{
            c.drawRGB(39,97,166)

            p.color = Color.WHITE
            c.drawCircle(300f+cont, 100f, 150f, p)


            p.color = Color.rgb(19, 67, 21)
            c.drawCircle(2160f, 4500f, 3500f, p)
            p.color = Color.rgb(19, 67, 21)
            c.drawCircle(-1080f, 4500f, 3500f, p)
        }
        //El pica pica
        c.drawBitmap(
            BitmapFactory.decodeResource(resources,
            R.drawable.hongoo
        ), posX, posY, p)
    }

    class Hilo1(p: Lienzo):Thread(){
        var act=p
        override fun run() {
            super.run()
            while (true){
                if (act.cont==1000){
                    act.cont=0
                }
                act.cont+=5
                sleep(50)
                println(act.cont)
            }
        }
    }
}