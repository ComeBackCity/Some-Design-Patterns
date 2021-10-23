package Problem2;

public interface computerFactory {
    resolution createResolution();
    cpu createCPU();
    mmu createMMU();
    resolution returnResolution();
    void cpummuInfo();
}
