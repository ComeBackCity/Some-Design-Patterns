package Problem2;

public class computerFactoryA extends cpuA implements computerFactory {

    @Override
    public resolution createResolution() {
        return new resA();
    }

    @Override
    public cpu createCPU() {
        return new cpuA();
    }

    @Override
    public mmu createMMU() {
        return new mmuA();
    }

    @Override
    public resolution returnResolution() {
        return new resA();
    }

    @Override
    public void cpummuInfo() {
        System.out.println(new cpuA());
        System.out.println(new mmuA());
    }
}
