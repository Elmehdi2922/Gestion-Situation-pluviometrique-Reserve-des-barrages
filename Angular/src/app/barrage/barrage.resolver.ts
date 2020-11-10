import {Injectable} from '@angular/core';
import {Resolve} from '@angular/router';
import {BarrageService} from './barrage.service';
@Injectable()
export class BarrageResolver implements Resolve<any>{

    constructor(private barrageService: BarrageService)
    {

    }

    resolve(){
        return this.barrageService.getBarrages();
    }
}
