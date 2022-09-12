import { WebPlugin } from '@capacitor/core';

import type { LocalStorageMigratorPlugin } from './definitions';

export class LocalStorageMigratorWeb
  extends WebPlugin
  implements LocalStorageMigratorPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
