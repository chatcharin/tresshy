/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rmutl.tresshy.perspectivetf;

/**
 *
 * @author catchajaa
 */
public class PerspectiveTransForm {
  public  double xp;
  public  double yp;
  private double A,B,C,D,l;
  public void sethomography(double point[]){
//      B = [ X Y ones(size(X)) zeros(4,3)        -X.*Xp -Y.*Xp ...
//      zeros(4,3)        X Y ones(size(X)) -X.*Yp -Y.*Yp ];
//      B = reshape (B', 8 , 8 )';
//      D = [ Xp , Yp ];
//      D = reshape (D', 8 , 1 );
//      l = inv(B' * B) * B' * D;
//      A = reshape([l(1:6)' 0 0 1 ],3,3)';
//      C = [l(7:8)' 1];
  }
   public void setXP(double xp)
   {
      this.xp = xp;
   }
   public void setYP(double yp)
   {
      this.yp = xp;
   }

}
