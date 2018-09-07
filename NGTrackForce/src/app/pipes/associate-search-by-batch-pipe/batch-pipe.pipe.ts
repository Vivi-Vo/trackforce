import { Pipe, PipeTransform } from '@angular/core';
@Pipe({
  name: 'pipeByBatch'
})
export class AssociateSearchByBatchPipe implements PipeTransform {
  transform(items: any[], searchText: string): any[] {
    if (!items) {
      return [];
    }
    if (!searchText) {
      return items;
    }
    return items.filter(associate => {
      return ((associate.batch != null) ? associate.batch.batchName === searchText : false);
    });
  }
}

