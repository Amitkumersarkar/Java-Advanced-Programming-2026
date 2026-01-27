class Smartphone
{
    private String brand;
    private String model;
    private int storage;

    void setBrand(String b)
    {
        brand = b;
    }

    void setModel(String m)
    {
        model = m;
    }

    void setStorage(int s)
    {
        storage = s;
    }

    int getStorage()
    {
        return storage;
    }

    void increaseStorage(int value)
    {
        storage = storage + value;
    }

    public static void main(String args[])
    {
        Smartphone s = new Smartphone();

        s.setBrand("Iphone");
        s.setModel("17 pro");
        s.setStorage(128);

        s.increaseStorage(32);

        System.out.println("Brand : " + s.brand);
        System.out.println("Model : " + s.model);
        System.out.println("Storage : " + s.getStorage() + " GB");
    }
}
