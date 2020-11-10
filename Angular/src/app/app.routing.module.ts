import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { BarrageComponent } from './barrage/barrage.component';
import { ProvinceComponent } from './province/province.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { PluieComponent } from './pluie/pluie.component';
import { BassinComponent } from './bassin/bassin.component';
import { CapaciteComponent } from './capacite/capacite.component';

import { BarrageResolver } from './barrage/barrage.resolver';


export const appRoutes: Routes = [
{path: 'login',component: LoginComponent},
{
  path: 'home',component: HomeComponent,
  children: [
              {
                path: 'dashboard',
                component: DashboardComponent,
                outlet: 'contentOutlet'
              },
              {
                path: 'barrage',
                component: BarrageComponent,

                outlet: 'contentOutlet'
              },
              {
                path: 'bassin',
                component: BassinComponent,

                outlet: 'contentOutlet'
              },
              {
                path: 'capacite',
                component: CapaciteComponent,

                outlet: 'contentOutlet'
              },
              {
                path: 'pluie',
                component: PluieComponent,

                outlet: 'contentOutlet'
              },
              {
                path: 'province',
                component: ProvinceComponent,
                outlet: 'contentOutlet'
              }
            ]

          },
  {path: '',redirectTo: '/home',pathMatch:'full'}
];
@NgModule({
  imports: [
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: false}
  )
],
exports: [RouterModule],
providers: [BarrageResolver]
})

export class AppRoutingModule{


}
