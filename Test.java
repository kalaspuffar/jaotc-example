public class Test {
    private int[] foundPrimes = new int[10];

    private boolean isPrime(int n) {
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    public void findPrime(int n) throws Exception {
        int nextPrime = n > 0 ? this.foundPrimes[n-1] + 1 : 500;
        while(!isPrime(nextPrime)) {
            nextPrime++;
        }
        this.foundPrimes[n] = nextPrime;
    }

    public static void main(String[] args) throws Exception {
        Test t = new Test();
        for (int i = 0; i < t.foundPrimes.length; i++) {
            System.out.print("call " + (i+1) + " ");
            long start = System.nanoTime();
            t.findPrime(i);
            long end = System.nanoTime();
            System.out.println("elapsed= " + (end-start));
        }
    }
}