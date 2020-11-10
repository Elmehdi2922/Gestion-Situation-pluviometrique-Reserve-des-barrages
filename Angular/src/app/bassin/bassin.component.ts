import { Component, OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Papa } from 'ngx-papaparse';

import { BassinService } from './bassin.service';
import { Bassin,Bassin2,Bassin4 } from '../shared/bassin';

import { ProvinceService } from '../province/province.service';
import { Province } from '../shared/province';

@Component({
  selector: 'app-bassin',
  templateUrl: './bassin.component.html',
  styleUrls: ['./bassin.component.css']
})
export class BassinComponent implements OnInit {

  title = 'Mr Mehdi . Bassin works!';
  operation = 'add';
  operation2 = 'add';
  bassins: Bassin4[];
  selectedBassin: Bassin;
  bassinForm: FormGroup;
  provinces: Province[];
  province: Province;
  varvar=1;
  test = [];
  constructor(
    private bassinService: BassinService,
    private fb:FormBuilder,
    private route: ActivatedRoute,
    private provinceService: ProvinceService,
    private papa : Papa
  )
  {
      this.bassinForm= this.fb.group({
        id:['',Validators.required],
        nom:'',
        province:['',Validators.required]

      })
  }

  initBassin(){
    this.selectedBassin=new Bassin();
    this.loadBassins();
    this.loadProvinces();
  }

  ngOnInit()
  {
    this.initBassin();

  }
  loadBassins(){
    this.bassinService.getBassins().subscribe(
      data => {this.bassins= data },
      error => { console.log('erreur load bassins !')},
      () => { console.log('loading bassins was done.')}
    );
  }
  loadProvinces(){
    this.provinceService.getProvinces().subscribe(
      data => {this.provinces= data},
      error => { console.log('erreur load provinces !')},
      () => { console.log('loading provinces was done.')}
    );
  }

  addBassin(){
    const b = this.bassinForm.value;
    this.add(b);
    this.operation = 'add';
  }

  add(b :Bassin2){
    this.bassinService.addBassin(b).subscribe(
      data => {}, error => { console.log('erreur save bassins !')},
      () => { console.log('bassins saved !');this.initBassin();  }
    );   
    
  }
  
  deleteBassin(bassin : Bassin){
    const b = this.bassinForm.value;
    this.bassinService.deleteBassin(bassin).subscribe(
      data => {},
      error => { console.log('erreur delete bassins !')},
      () => { console.log('deleting bassins was done.')}
    );
    this.operation = 'add';
    this.initBassin();
  }

  saveupdateBassin(){
    const b = this.bassinForm.value;
    this.bassinService.saveupdateBassin(b).subscribe(
      error => { console.log('erreur update bassin !')},
      () => { console.log('updating bassin was done.')}
    );
    this.initBassin();
  }

  changerSelect(b : Bassin)
  {
      this.varvar=b.proid;
  }

  ConvertCSVtoJSON() {
      console.log(JSON.stringify(this.test));

  }
    
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
             this.add(new Bassin2(0,results.data[i].nom,results.data[i].province));
             this.test.push(results.data[i].nom,);
            }
            console.log('Parsed: ', results.data);
          }
        });
      }
    }
}
