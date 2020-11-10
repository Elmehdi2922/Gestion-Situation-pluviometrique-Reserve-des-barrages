import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { Bassin,Bassin2, Bassin4 } from '../shared/bassin';


import {API_URLS} from '../config/api.url.config';

@Injectable()
export class BassinService{
  constructor(private http: HttpClient)
  {

  }

  getBassins(): Observable<any>{
      return this.http.get('http://localhost:8080/api/sbassins/All');
  }
  getBassins3(): Observable<any>{
      return this.http.get('http://localhost:8080/api/provinces/get_sbassin.info4');
  }
  getBassin(varx : number): Observable<any>{
      return this.http.get('http://localhost:8080/api/sbassins/getOne/'+varx);
  }
  getBassins2(varx : number): Observable<any>{
      return this.http.get("http://localhost:8080/api/provinces/get_sbassinbyprovince.info/"+varx);
  }

  addBassin(bassin : Bassin2): Observable<any>{
      const body = { "nom" : bassin.nom,"province" : {"id" : bassin.province }};console.log("body= "+JSON.stringify(body));
      return this.http.post("http://localhost:8080/api/sbassins/add",body);
  }
  addBassin2(x : string,y : string): Observable<any>{
      //?nom="+x+"&province="+y
      return this.http.post("http://localhost:8080/api/sbassins/add",x);
  }
  deleteBassin(bassin : Bassin): Observable<any>{
      return this.http.delete("http://localhost:8080/api/sbassins/delete/"+bassin.id);
  }

  saveupdateBassin(bassin : Bassin2): Observable<any>{
      const body = { "id" : bassin.id, "nom" : bassin.nom, "province" : {"id" : bassin.province }};
      return this.http.put("http://localhost:8080/api/sbassins/update",body);
  }

}
