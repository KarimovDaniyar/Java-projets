public class Example<T, V> {
    private String string = "";

    public String getString(){
        return string;
    }

    public void addToString(T t, V v){
        if(this.string.equals("")){
            this.string += t.toString() +" - "+ v.toString();
        }else{
            this.string += " - " + t.toString() + " - " + v.toString();
        }
    }
}
