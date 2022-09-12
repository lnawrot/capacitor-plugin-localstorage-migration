import { WebPlugin } from '@capacitor/core';
import type { LocalStorageMigratorPlugin } from './definitions';
export declare class LocalStorageMigratorWeb extends WebPlugin implements LocalStorageMigratorPlugin {
    read({ key }: {
        key: string;
    }): Promise<{
        value: string | null;
    }>;
}
