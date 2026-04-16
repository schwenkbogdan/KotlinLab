Л.р.2. Kotlin. Разработка класса структуры данных
Портировать из Java разработанный в л.р.1 программный код.
В отчете – особенности специфики реализации тех или иных компонент
портируемого кода и его цитаты.

Код ЛР2
ПРиложение 1. Класс vector
```java
import java.io.*;

public class Vector{

    double X,Y;

    public Vector(double x,double y)
    {
        this.X = x;
        this.Y = y;
    }

    public Vector()
    {
        this.X = 0;
        this.Y = 0;
    }

    public double length()
    {
        return Math.sqrt( Math.pow(this.X,2) + Math.pow(this.Y,2));
    }

    public void print()
    {
        IO.println("("+this.X+";"+this.Y+")");
    }

    public void Set(double x, double y)
    {
        this.X = x;
        this.Y = y;
    }

    public void SetX(double x)
    {
        this.X = x;
    }

    public void SetY(double y)
    {
        this.Y = y;
    }


    public double GetX()
    {
        return this.X;
    }
    public double GetY()
    {
        return this.Y;
    }

    public void outToText(OutputStream out) throws IOException
    {
        try(PrintWriter prt = new PrintWriter(new OutputStreamWriter(out))) {
            prt.println("(" + this.X + ";" + this.Y + ")");
            prt.flush();
        }
    }

    public void outToBinary(OutputStream out) throws IOException
    {
        try(DataOutputStream dataOut = new DataOutputStream(out)) {
            dataOut.writeDouble(X);
            dataOut.writeDouble(Y);
            dataOut.flush();
        }
    }

    public void inFromText(InputStream in) throws IOException
    {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(in)))
        {
            String line = reader.readLine();
            String[] halfs = line.split("\\s+");
            X=Double.parseDouble(halfs[0]);
            Y=Double.parseDouble(halfs[1]);
        }
    }
    public void inFromBinary(InputStream in) throws IOException
    {
        try(DataInputStream dataIn = new DataInputStream(in)) {
            X = dataIn.readDouble();
            Y = dataIn.readDouble();
        }
    }
}
```

ПРиложение 2. Класс Calc
```java        
public class Calc {
    public Vector sum(Vector a, Vector b)
    {
        Vector tmp = new Vector();
        tmp.X = a.X + b.X;
        tmp.Y = a.Y + b.Y;
        return tmp;
    }

    public Vector sub(Vector a, Vector b)
    {
        Vector tmp = new Vector();
        tmp.X = a.X - b.X;
        tmp.Y = a.Y - b.Y;
        return tmp;
    }

    public Vector mul(Vector a,double b)
    {
        Vector tmp = new Vector();
        tmp.X = a.X*b;
        tmp.Y = a.Y*b;
        return tmp;
    }

    public Vector mul(Vector a, int b)
    {
        Vector tmp = new Vector();
        tmp.X = a.X*b;
        tmp.Y = a.Y*b;
        return tmp;
    }

    public Vector mul(Vector a, float b)
    {
        Vector tmp = new Vector();
        tmp.X = a.X*b;
        tmp.Y = a.Y*b;
        return tmp;
    }

    public  double scal_mul(Vector a, Vector b, double agl)
    {
        return a.length()*b.length()*Math.cos(agl);
    }

    public  double scal_mul(Vector a, Vector b, float agl)
    {
        return a.length()*b.length()*Math.cos(agl);
    }
}
```