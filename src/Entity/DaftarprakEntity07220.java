/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Agam
 */
public class DaftarprakEntity07220 {
    private PraktikanEntity07220 praktikan;
    private boolean isVerified;
    private int indexPraktikum;

    public DaftarprakEntity07220(PraktikanEntity07220 praktikan, boolean isVerified, int indexPraktikum) {
        this.praktikan = praktikan;
        this.isVerified = isVerified;
        this.indexPraktikum = indexPraktikum;
    }

    public PraktikanEntity07220 getPraktikan() {
        return praktikan;
    }

    public void setPraktikan(PraktikanEntity07220 praktikan) {
        this.praktikan = praktikan;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        isVerified = isVerified;
    }

    public int getIndexPrak() {
        return indexPraktikum;
    }

    public void setIndexPrak(int indexPrak) {
        this.indexPraktikum = indexPrak;
    }
    
    
}
