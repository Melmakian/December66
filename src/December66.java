import java.io.*;

public class December66 implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;


    public December66(Thread runner, int speed) {
        this.runner = runner;
        this.speed = speed;
        runner.start();
    }

    @Override
    public void run() {

    }

    public void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(speed);
    }


    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        speed = in.readInt();
        runner = new Thread(this);
        runner.start();
    }
}
