import { Component,OnInit } from '@angular/core';
import { FormGroup,FormBuilder,Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Papa } from 'ngx-papaparse';

import { BarrageService } from './barrage.service';
import { Barrage } from '../shared/barrage';

@Component({
  selector: 'app-barrage',
  templateUrl: './barrage.component.html',
  styleUrls: ['./barrage.component.css']
})
export class BarrageComponent implements OnInit{
  title = 'Mr Mehdi . Barrage works!';
  operation = 'add';
  operation2 = 'add';
  barrages: Barrage[];
  barrage: Barrage;
  selectedBarrage: Barrage;
  barrageForm: FormGroup;

  constructor(private barrageService: BarrageService,private fb:FormBuilder, private route: ActivatedRoute,private papa : Papa)
  {
      this.barrageForm= this.fb.group({
        id:['',Validators.required],
        nom:'',
        vol:['',Validators.required]

      })
  }

  initBarrage(){
    this.selectedBarrage=new Barrage();
   
  }
  
  ngOnInit()
  {
    this.initBarrage();
    this.loadBarrages();
  }
  
  loadBarrages(){
    this.barrageService.getBarrages().subscribe(
      data => {this.barrages= data },
      error => { console.log('erreur load barrages !')},
      () => { console.log('loading barrage was done.')}
    );
  }
  addBarrage(){
    const b = this.barrageForm.value;
    this.add(b);
    
  }

  add(b : Barrage){
    
    this.barrageService.addBarrage(b).subscribe(
      data => {},error => { console.log('erreur save barrages !')},
      () => { console.log('barrages saved !');
              this.initBarrage();
              this.loadBarrages(); 
            }
    );
    
  }
  deleteBarrage(barrage : Barrage){
    const b = this.barrageForm.value;
    this.barrageService.deleteBarrage(barrage).subscribe(
      data => {},error => { console.log('erreur delete barrages !')},
      () => { console.log('deleting barrage was done.');
              this.initBarrage();
              this.loadBarrages(); 
            }
    );
    this.operation = 'add';    
  }
  saveupdateBarrage(){
    const b = this.barrageForm.value;
    this.barrageService.saveupdateBarrage(b).subscribe(
      data => {},error => { console.log('erreur update barrage !')},
      () => { console.log('updating barrage was done.');
              this.initBarrage();
              this.loadBarrages(); 
            }
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
      var vol : number;
      reader.readAsText(file);
      reader.onload = (event: any) => {
        var csv = event.target.result; // Content of CSV file
        this.papa.parse(csv, {
          skipEmptyLines: true,
          header: true,
          complete: (results) => {
            for (let i = 0; i < results.data.length; i++) {

              vol = + results.data[i].vol;
              console.log(' results.data[i].nom : ',  results.data[i].nom);
              console.log('results.data[i].vol :  ',   results.data[i].vol );
              this.add(new Barrage(0,"dd",results.data[i].nom,vol));
              this.test.push(results.data[i].nom);
             
            }
            // console.log(this.test);
            console.log('Parsed: k', results.data);
          }
        });
      }
    }

}
