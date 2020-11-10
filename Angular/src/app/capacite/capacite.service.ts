import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import { Capacite,Capacite2 } from '../shared/capacite';


import {API_URLS} from '../config/api.url.config';

@Injectable()
export class CapaciteService{
  constructor(private http: HttpClient)
  {

  }

  getCapacites(): Observable<any>{
      return this.http.get('http://localhost:8080/api/capacites/get_aujour.info3');
  }
  getCapacites3(): Observable<any>{
      return this.http.get('http://localhost:8080/api/capacites/get_aujour.info4');
  }
  getCapacites2(): Observable<any>{
      return this.http.get('');
  }

  addCapacite(capacite : Capacite): Observable<any>{
    const body = { "volume":capacite.volume,"ddate": capacite.ddate,"barrage": {"id": capacite.nom}};console.log("body= "+JSON.stringify(body));
    return this.http.post("http://localhost:8080/api/capacites/add",body);
  }
  addCapacite2(nom : string , ddate : string , volume : string): Observable<any>{
      return this.http.post("http://localhost:8080/api/capacites/add_capacite.info.php?barrage="+nom+"&ddate="+ddate+"&volume="+volume,nom);
  }
  deleteCapacite(capacite : number): Observable<any>{
      return this.http.delete("http://localhost:8080/api/capacites/delete/"+capacite);
  }

  saveupdateCapacite(capacite : Capacite): Observable<any>{
    const body = { "id":capacite.id, "volume":capacite.volume,"ddate": capacite.ddate,"barrage": {"id": capacite.nom}};console.log("body= "+JSON.stringify(body));
      return this.http.put("http://localhost:8080/api/capacites/update",body);
  }

}
