class Time
{
    int h, m, s;

    Time(int h, int m, int s)
    {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    static Time add_time(Time t1, Time t2)
    {
        int sec = t1.s + t2.s;
        int min = t1.m + t2.m + sec / 60;
        int hr  = t1.h + t2.h + min / 60;

        sec = sec % 60;
        min = min % 60;

        return new Time(hr, min, sec);
    }

    void display()
    {
        System.out.println("Result Time : " + h + ":" + m + ":" + s);
    }

    public static void main(String args[])
    {
        Time t1 = new Time(2, 55, 40);
        Time t2 = new Time(5, 20, 30);

        Time t3 = add_time(t1, t2);
        t3.display();
    }
}
