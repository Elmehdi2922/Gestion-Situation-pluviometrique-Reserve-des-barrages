import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import 'rxjs/add/operator/finally';




@Injectable()
export class AppService {

  authenticated: boolean = false;

  constructor(private http: HttpClient, private cookieservice: CookieService) { }


  authenticate(credentials, callback){
    if(credentials)
    {
      const token = btoa(credentials.username+':'+credentials.password);
      this.cookieservice.set('token', token);

        this.http.get('http://localhost:8080/api/user').subscribe(response =>{
            if(response && response['name']){
              this.authenticated = true;
            }else
            {
              this.authenticated = false;
            }
            return callback && callback();

         });
    }else
    {
      this.authenticated = false;
    }

  }


}
