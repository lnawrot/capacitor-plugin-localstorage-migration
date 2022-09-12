import { registerPlugin } from '@capacitor/core';

import type { LocalStorageMigratorPlugin } from './definitions';

const LocalStorageMigrator = registerPlugin<LocalStorageMigratorPlugin>(
  'LocalStorageMigrator',
  {
    web: () => import('./web').then(m => new m.LocalStorageMigratorWeb()),
  },
);

export * from './definitions';
export { LocalStorageMigrator };
