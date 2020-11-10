import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Papa } from 'ngx-papaparse';

import { CapaciteService } from './capacite.service';
import { Capacite,Capacite2 } from '../shared/capacite';

import { BarrageService } from '../barrage/barrage.service';
import { Barrage } from '../shared/barrage';

@Component({
  selector: 'app-capacite',
  templateUrl: './capacite.component.html',
  styleUrls: ['./capacite.component.css']
})
export class CapaciteComponent implements OnInit {
  title = 'Mr Mehdi . Capacite works!';
  operation = 'add';
  operation2 = 'add';
  varmax=0;
  varmin=1;
  selected='dd';
  bb: Capacite2[];
  capacites: [][];
  cap: [][];
  selectedCapacite: Capacite;
  capaciteForm: FormGroup;
  barrages: Barrage[];
  bar: Barrage;
  varvar=1;
  constructor(private capaciteService: CapaciteService,private fb:FormBuilder, private route: ActivatedRoute,private barrageService: BarrageService,private papa : Papa)
  {
      this.capaciteForm= this.fb.group({
        id:['',Validators.required],
        nom:'',
        ddate:'',
        volume:''


      })
  }
  
  initCapacite(){
    this.selectedCapacite=new Capacite();
    this.loadCapacites();
    this.loadBarrages();
  }

  ngOnInit()
  {
    this.initCapacite();
  }

  loadCapacites(){
    this.capaciteService.getCapacites().subscribe(
      data => {this.capacites= data },
      error => { console.log('erreur load capacites !')},
      () => { console.log('loading capacites was done.')}
    );
  }
  loadBarrages(){
    this.barrageService.getBarrages().subscribe(
      data => {this.barrages= data},
      error => { console.log('erreur load barrages !')},
      () => { console.log('loading barrages was done.')}
    );
  }

  addCapacite(){
    const b = this.capaciteForm.value;
    this.add(b);
  }

  add(b){
    this.capaciteService.addCapacite(b).subscribe(
      data => {},
      error => { console.log('erreur save capacites !')},
      () => { console.log('capacites saved !') }
    );
    this.operation = 'add';
    this.initCapacite();
  }

  deleteCapacite(capacite){
    this.capaciteService.deleteCapacite(capacite.id).subscribe(
      data => {},
      error => { console.log('erreur delete capacites !');},
      () => { console.log('deleting capacites was done.');this.initCapacite();}
    );
    this.operation = 'add';
    
  }

  saveupdateCapacite(){
    const b = this.capaciteForm.value;
    this.capaciteService.saveupdateCapacite(b).subscribe(
      data => {},
      error => { console.log('erreur update capacites !')},
      () => { console.log('updating capacites was done.')}
    );
    this.initCapacite();
  }

  changerSelect(b)
  {
      this.varmax=b[2];
      this.selectedCapacite.id=b[0];
      this.selectedCapacite.nom=b[1];
      this.selectedCapacite.ddate=b[4];
      this.selectedCapacite.volume=b[3];
  }

  SelectCapacite(b)
  {
      this.varmax=b[2];
      this.selectedCapacite.id=b[0];
      this.selectedCapacite.nom=b[1];
      this.selectedCapacite.ddate=b[4];
      this.selectedCapacite.volume=b[3];
  }
  
  valmax(){
    const b = this.capaciteForm.value;
    this.barrageService.getBarrage(b.nom).subscribe(
      data => {this.bar= data},
      error => { console.log('erreur load barrages !')},
      () => {this.varmax=this.bar.vol;console.log('mavxval'+b.nom+':'+this.varmax+' = '+this.bar.vol) }
    );

  }

  ConvertCSVtoJSON() {
      console.log(JSON.stringify(this.test));

    }
    test = [];
    handleFileSelect(evt) {
      var files = evt.target.files; // FileList object
      var file = files[0];
      var reader = new FileReader();
      reader.readAsText(file);
      reader.onload = (event: any) => {
        var csv = event.target.result; // Content of CSV file
        this.papa.parse(csv, {
          skipEmptyLines: true,
          header: true,
          complete: (results) => {
            for (let i = 0; i < results.data.length; i++) {
              console.log('results.data[i].date :  ',   results.data[i].date );
              console.log('results.data[i].volume :  ',   results.data[i].volume );
              this.add(new Capacite(0,results.data[i].barrage,results.data[i].date,results.data[i].volume,0));
              this.test.push(results.data[i].nom);
            }
            // console.log(this.test);
            console.log('Parsed: ', results.data);
          }
        });
      }
    }



  }
