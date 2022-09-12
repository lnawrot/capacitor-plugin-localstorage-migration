import { WebPlugin } from '@capacitor/core';

import type { LocalStorageMigratorPlugin } from './definitions';

export class LocalStorageMigratorWeb
  extends WebPlugin
  implements LocalStorageMigratorPlugin
{
  async read(key: string): Promise<{ value: string | null }> {
    return { value: localStorage.getItem(key) };
  }
}
