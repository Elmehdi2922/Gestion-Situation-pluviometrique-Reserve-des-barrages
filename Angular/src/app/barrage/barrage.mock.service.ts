import {Injectable} from '@angular/core';

import {Barrage} from '../shared/barrage';

@Injectable()
export class BarrageMockService
{
  private BARRAGES: Barrage[] = [];

  constructor()
  {
    let p1: Barrage = new Barrage(1,"","Bin El Ouidane",1215.50);
    let p2: Barrage = new Barrage(2,"","Hassan 1er",236.04);
    let p3: Barrage = new Barrage(3,"","Sidi Driss",2.45);
    let p4: Barrage = new Barrage(4,"","Moulay Youssef",142.80);
    let p5: Barrage = new Barrage(5,"","Timinoutine", 1.35);
    let p6: Barrage = new Barrage(6,"","Ahmed Al Hanssali", 668.17);
    let p7: Barrage = new Barrage(7,"","Ait Messaoud", 14.33);
    let p8: Barrage = new Barrage(8,"","Al Massira", 2656.99);
    let p9: Barrage = new Barrage(9,"","Imfout", 9.41);
    let p10: Barrage = new Barrage(10,"","Daourat", 6.76);
    let p11: Barrage = new Barrage(11,"","Sidi Said Maachou",1.10);
    this.BARRAGES.push(p1);
    this.BARRAGES.push(p2);
    this.BARRAGES.push(p3);
    this.BARRAGES.push(p4);
    this.BARRAGES.push(p5);
    this.BARRAGES.push(p6);
    this.BARRAGES.push(p7);
    this.BARRAGES.push(p8);
    this.BARRAGES.push(p9);
    this.BARRAGES.push(p10);
    this.BARRAGES.push(p11);
  }

  public getBarrages(): Barrage[]{
    return this.BARRAGES;
  }
}
