package bases;

/**
 * Created by duyanh on 10/18/17.
 */
public class Vector2D {
    public float x;
    public float y;

    public Vector2D(){
        this.x = 0;
        this.y = 0;
    }

    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void set(float x,float y){
        this.x = x;
        this.y = y;
    }

    public void print(){
        System.out.println("x: "+x+", y: "+y);
    }

    public Vector2D clone_v(){
        Vector2D vector2D = new Vector2D(x,y);
        return vector2D;
    }

    public void addUp(float x, float y){

         this.x += x;
        this.y += y;
    }

    public void subtractBy(float x,float y){

        this.x -= x;
        this.y -= y;
    }

    public Vector2D subtractBy(Vector2D vector2D){
        this.x -= vector2D.x ;
        this.y -= vector2D.y ;
        return this;
    }

    public Vector2D addUp(Vector2D vector2D){

        this.x += vector2D.x;
        this.y += vector2D.y;
        return this;

    }


    public Vector2D add(float x,float y){
        Vector2D vector2D = new Vector2D();
        vector2D.x = this.x + x;
        vector2D.y = this.y + y;
        return  vector2D;
    }

    public Vector2D subtract(float x, float y){
        Vector2D vector2D = new Vector2D();
        vector2D.x = this.x - x;
        vector2D.y = this.y - y;
        return  vector2D;
    }


    public Vector2D add(Vector2D vector2D){

        vector2D.x = this.x + vector2D.x;
        vector2D.y = this.y + vector2D.y;

        return vector2D;
    }

    public Vector2D subtract(Vector2D vector2D){

        this.x = this.x - vector2D.x ;
        this.y = this.y - vector2D.y;
        return  vector2D;
    }

    public Vector2D mutiply (float i){
        Vector2D vector2D = new Vector2D();

        vector2D.x = this.x *  i;
        vector2D.y = this.y * i;
        return vector2D;
    }

    public float length(){
        Vector2D vector2D = new Vector2D(this.x, this.y);
        float length = (float) Math.sqrt(vector2D.x*vector2D.x + vector2D.y*vector2D.y);
        return length;
    }


}
