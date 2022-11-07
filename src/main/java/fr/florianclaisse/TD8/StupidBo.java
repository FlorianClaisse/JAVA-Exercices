package fr.florianclaisse.TD8;

/**
 * A Business object, stupid one...
 */
public class StupidBo {
    private String message;
    private int counter;

    public StupidBo() {
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o instanceof StupidBo) {
            StupidBo stupidBo = (StupidBo) o;
            return counter == stupidBo.counter &&
                    message.equals(stupidBo.message);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
