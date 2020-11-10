import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule,HTTP_INTERCEPTORS } from '@angular/common/http';


import { AppComponent } from './app.component';
import { BarrageComponent } from './barrage/barrage.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { BarrageMockService } from './barrage/barrage.mock.service';
import { ProvinceMockService } from './province/province.mock.service';
import { Barrage } from './shared/barrage';
import { ProvinceComponent } from './province/province.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { ContentComponent } from './content/content.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { AppRoutingModule } from './app.routing.module';
import { CookieService } from 'ngx-cookie-service'; 
import { BarrageService } from './barrage/barrage.service';
import { CapaciteService } from './capacite/capacite.service';
import { PluieService } from './pluie/pluie.service';
import { BassinService } from './bassin/bassin.service';
import { ProvinceService } from './province/province.service';
import { AppService } from './app.service';
import { XhrInterceptor } from './xhr.interceptor';
import { BassinComponent } from './bassin/bassin.component';
import { CapaciteComponent } from './capacite/capacite.component';
import { PluieComponent } from './pluie/pluie.component';
import { ReclamationComponent } from './reclamation/reclamation.component';

@NgModule({
  declarations: [
    AppComponent,
    BarrageComponent,
    ProvinceComponent,
    NavbarComponent,
    SidebarComponent,
    ContentComponent,
    DashboardComponent,
    LoginComponent,
    HomeComponent,
    BassinComponent,
    CapaciteComponent,
    PluieComponent,
    ReclamationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [
    BarrageMockService,
    ProvinceMockService,
    BarrageService,
    ProvinceService,
    AppService,
    CookieService,
    BassinService,
    CapaciteService,
    PluieService,
    {provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }


  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
