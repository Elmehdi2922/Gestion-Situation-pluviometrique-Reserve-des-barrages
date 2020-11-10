import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { Barrage,Barrage4 } from '../shared/barrage';


import {API_URLS} from '../config/api.url.config';

@Injectable()
export class BarrageService{
  constructor(private http: HttpClient)
  {

  }

  getBarrages(): Observable<any>{
      return this.http.get('http://localhost:8080/api/barrages/All');
  }
  getBarrage(id: number): Observable<any>{
      return this.http.get("http://localhost:8080/api/barrages/getOne/"+id);
  }
  getBarrages2(): Observable<any>{
      return this.http.get("http://localhost:8080/api/capacites/get_aujour-bar.info2");
  }
  getBarrages3(): Observable<any>{
      return this.http.get("http://localhost:8080/api/capacites/get_barrages.info3");
  }
  getBarrages5(): Observable<any>{
      return this.http.get("http://localhost:8080/api/capacites/get_aujour.info5");
  }

  addBarrage(barrage : Barrage): Observable<any>{
      //const body = { nom:barrage.nom,vol:barrage.vol };
      return this.http.post("http://localhost:8080/api/barrages/add",barrage);
  }
  addBarrage2(nom : string, vol : string): Observable<any>{
      const barrage = new Barrage4("dd",nom,10.2 );
      return this.http.post("http://localhost:8080/api/barrages/add",barrage);
  }
  deleteBarrage(barrage : Barrage): Observable<any>{
      return this.http.delete("http://localhost:8080/api/barrages/delete/"+barrage.id);
  }

  saveupdateBarrage(barrage : Barrage): Observable<any>{
      return this.http.put("http://localhost:8080/api/barrages/update",barrage);
  }

}
