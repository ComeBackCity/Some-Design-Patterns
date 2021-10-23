package Problem2;

public class computerFactoryC extends cpuC implements computerFactory {
    @Override
    public resolution createResolution() {
        return new resB();
    }

    @Override
    public cpu createCPU() {
        return new cpuB();
    }

    @Override
    public mmu createMMU() {
        return new mmuB();
    }

    @Override
    public resolution returnResolution() {
        return new resC();
    }

    @Override
    public void cpummuInfo() {
        System.out.println(new cpuB());
        System.out.println(new mmuB());
    }
}
